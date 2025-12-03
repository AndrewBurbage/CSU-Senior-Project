// start-call.js
export default {
  async fetch(request, env) {
    if (request.method !== "POST") {
      return new Response("Use POST", { status: 405 });
    }

    let body;
    try {
      body = await request.json();
    } catch (e) {
      return new Response("Invalid JSON body", { status: 400 });
    }

    const to = body.to;
    const script = body.script;

    if (!to || !script) {
      return new Response("Missing 'to' or 'script'", { status: 400 });
    }

    const accountSid = env.TWILIO_SID;
    const authToken = env.TWILIO_TOKEN;
    const fromNumber = env.TWILIO_NUMBER;

    const safeScript = script
      .replace(/&/g, "&amp;")
      .replace(/</g, "&lt;")
      .replace(/>/g, "&gt;")
      .replace(/"/g, "&quot;")
      .replace(/'/g, "&apos;");

    const twiml = `<Response><Say>${safeScript}</Say></Response>`;

    const formData = new URLSearchParams();
    formData.append("To", to);
    formData.append("From", fromNumber);
    formData.append("Twiml", twiml);

    const authHeader = "Basic " + btoa(`${accountSid}:${authToken}`);

    let response;
    let resultText;

    try {
      response = await fetch(
        `https://api.twilio.com/2010-04-01/Accounts/${accountSid}/Calls.json`,
        {
          method: "POST",
          headers: {
            Authorization: authHeader,
            "Content-Type": "application/x-www-form-urlencoded",
          },
          body: formData,
        }
      );

      resultText = await response.text();
      console.log("Twilio response:", resultText);
    } catch (err) {
      console.error("Error calling Twilio:", err);
      return new Response("Error contacting Twilio: " + err.toString(), { status: 500 });
    }

    return new Response(resultText, {
      status: response.status,
      headers: { "Content-Type": "application/json" },
    });
  },
};