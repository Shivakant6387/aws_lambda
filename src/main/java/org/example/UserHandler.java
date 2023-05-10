package org.example;


import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.util.Map;

public class UserHandler implements RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {

    @Override
    public APIGatewayProxyResponseEvent handleRequest(APIGatewayProxyRequestEvent input, Context context) {
        Map<String, String> pathParameters = input.getPathParameters();
        JsonObject jsonObject=new JsonObject();
        String  userid= pathParameters.get("userid");
        jsonObject.addProperty("firstName","Shivakant");
        jsonObject.addProperty("lastName","Singh");

        jsonObject.addProperty("userid",userid);
        APIGatewayProxyResponseEvent response=new APIGatewayProxyResponseEvent();
        response.withStatusCode(200).setBody(jsonObject.toString());
        return response;
    }
}
