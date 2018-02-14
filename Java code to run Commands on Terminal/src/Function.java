package com.mustaqim;

import java.util.*;
import com.microsoft.azure.serverless.functions.annotation.*;
import com.microsoft.azure.serverless.functions.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Azure Functions with HTTP Trigger.
 */
public class Function {
    /**
     * This function listens at endpoint "/api/hello". Two ways to invoke it using "curl" command in bash:
     * 1. curl -d "HTTP Body" {your host}/api/hello
     * 2. curl {your host}/api/hello?name=HTTP%20Query
     */
    @FunctionName("hello")
    public HttpResponseMessage<String> hello(
            @HttpTrigger(name = "req", methods = {"get", "post"}, authLevel = AuthorizationLevel.ANONYMOUS) HttpRequestMessage<Optional<String>> request,
            final ExecutionContext context) {
        context.getLogger().info("Java HTTP trigger processed a request.");

        // Parse query parameter
        String query = request.getQueryParameters().get("name");
        String name = request.getBody().orElse(query);

        if (name == null) {
            return request.createResponse(400, "Please pass a name on the query string or in the request body");
        } else {
            return request.createResponse(200,  runCommand(name));
        }
    }
	
	public static String runCommand(String sCommand)
    {
        String output = "";
        
        StringBuilder sb = new StringBuilder();
		
		sb.append("Command is: " + sCommand + "\n");
        
        try
        {
        	String s = null;
        	
            ProcessBuilder pb = new ProcessBuilder(sCommand);
			Process p = pb.start();
            BufferedReader stdInput = new BufferedReader(new 
                    InputStreamReader(p.getInputStream()));

               BufferedReader stdError = new BufferedReader(new 
                    InputStreamReader(p.getErrorStream()));

               // read the output from the command
               sb.append("Here is the standard output of the command:\n");
               while ((s = stdInput.readLine()) != null) {
            	   sb.append(s);
               }
               
               // read any errors from the attempted command
               sb.append("\nHere is the standard error of the command (if any):\n");
               while ((s = stdError.readLine()) != null) {
            	   sb.append(s);
               }
           }
           catch (IOException e) {
        	   sb.append("exception happened - here's what I know: \n");
               sb.append(e.getMessage());
           }
        
        return sb.toString();
    }
}

package com.mustaqim;

import java.util.*;
import com.microsoft.azure.serverless.functions.annotation.*;
import com.microsoft.azure.serverless.functions.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Azure Functions with HTTP Trigger.
 */
public class Function {
    /**
     * This function listens at endpoint "/api/hello". Two ways to invoke it using "curl" command in bash:
     * 1. curl -d "HTTP Body" {your host}/api/hello
     * 2. curl {your host}/api/hello?name=HTTP%20Query
     */
    @FunctionName("hello")
    public HttpResponseMessage<String> hello(
            @HttpTrigger(name = "req", methods = {"get", "post"}, authLevel = AuthorizationLevel.ANONYMOUS) HttpRequestMessage<Optional<String>> request,
            final ExecutionContext context) {
        context.getLogger().info("Java HTTP trigger processed a request.");

        // Parse query parameter
        String query = request.getQueryParameters().get("name");
        String name = request.getBody().orElse(query);

        if (name == null) {
            return request.createResponse(400, "Please pass a name on the query string or in the request body");
        } else {
            return request.createResponse(200,  runCommand(name));
        }
    }
	
	public static String runCommand(String sCommand)
    {
        String output = "";
        
        StringBuilder sb = new StringBuilder();
		
		sb.append("Command is: " + sCommand + "\n");
        
        try
        {
        	String s = null;
        	
            ProcessBuilder pb = new ProcessBuilder(sCommand);
			Process p = pb.start();
            BufferedReader stdInput = new BufferedReader(new 
                    InputStreamReader(p.getInputStream()));

               BufferedReader stdError = new BufferedReader(new 
                    InputStreamReader(p.getErrorStream()));

               // read the output from the command
               sb.append("Here is the standard output of the command:\n");
               while ((s = stdInput.readLine()) != null) {
            	   sb.append(s);
               }
               
               // read any errors from the attempted command
               sb.append("\nHere is the standard error of the command (if any):\n");
               while ((s = stdError.readLine()) != null) {
            	   sb.append(s);
               }
           }
           catch (IOException e) {
        	   sb.append("exception happened - here's what I know: \n");
               sb.append(e.getMessage());
           }
        
        return sb.toString();
    }
}

