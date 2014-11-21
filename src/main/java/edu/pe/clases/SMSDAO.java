/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pe.clases;

import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.resource.factory.MessageFactory;
import com.twilio.sdk.resource.instance.Message;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

public class SMSDAO {
    
    static String AccountID="CI00139360";
    static String Email="20111286@aloe.ulima.edu.pe";
    static String Password="futbol5";
    
    public static int SendSMS(String Recipient, String Message, StringBuffer Response) throws MalformedURLException, UnsupportedEncodingException, IOException {
        String RequestURL = "http://www.redoxygen.net/sms.dll?Action=SendSMS";

        String Data = ("AccountId=" + URLEncoder.encode(AccountID, "UTF-8"));
        Data += ("&Email=" + URLEncoder.encode(Email, "UTF-8"));
        Data += ("&Password=" + URLEncoder.encode(Password, "UTF-8"));
        Data += ("&Recipient=" + URLEncoder.encode(Recipient, "UTF-8"));
        Data += ("&Message=" + URLEncoder.encode(Message, "UTF-8"));

        int Result = -1;
        URL Address = new URL(RequestURL);

        HttpURLConnection Connection = (HttpURLConnection) Address.openConnection();
        Connection.setRequestMethod("POST");
        Connection.setDoInput(true);
        Connection.setDoOutput(true);

        DataOutputStream Output;
        Output = new DataOutputStream(Connection.getOutputStream());
        Output.writeBytes(Data);
        Output.flush();
        Output.close();

        BufferedReader Input = new BufferedReader(new InputStreamReader(Connection.getInputStream()));
        StringBuffer ResponseBuffer = new StringBuffer();
        String InputLine;

        while ((InputLine = Input.readLine()) != null) {
            ResponseBuffer = ResponseBuffer.append(InputLine);
            ResponseBuffer = ResponseBuffer.append("\n\n\n");
        }

        Response.replace(0, 0, ResponseBuffer.toString());
        String ResultCode = Response.substring(0, 4);
        Result = Integer.parseInt(ResultCode);
        Input.close();

        return Result;
    }
}
