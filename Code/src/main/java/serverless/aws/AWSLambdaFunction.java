package serverless.aws;

import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.lambda.AWSLambda;
import com.amazonaws.services.lambda.AWSLambdaAsyncClient;
import com.amazonaws.services.lambda.AWSLambdaClient;
import com.amazonaws.services.lambda.AWSLambdaClientBuilder;
import com.amazonaws.services.lambda.model.InvokeRequest;
import com.amazonaws.services.lambda.model.InvokeResult;
import com.amazonaws.services.lambda.model.ServiceException;

import java.nio.charset.StandardCharsets;

public class AWSLambdaFunction {

    private final String functionName;


    public AWSLambdaFunction(String functionName) {

        this.functionName = functionName;
    }


    public void executeWithoutPayload(String region) {
        this.executeWithPayload(region, null);
    }

    public void executeWithPayload(String region, String payload) {

        InvokeRequest invokeRequest = new InvokeRequest();

        invokeRequest.setFunctionName(this.functionName);
        invokeRequest.setPayload(payload);

        InvokeResult invokeResult = null;

        try {
            AWSLambda awsLambda = AWSLambdaClientBuilder.standard()
                    .withCredentials(new ProfileCredentialsProvider())
                    .withRegion(Regions.US_EAST_1).build();

            invokeResult = awsLambda.invoke(invokeRequest);

            String ans = new String(invokeResult.getPayload().array(), StandardCharsets.UTF_8);

            //write out the return value
            System.out.println(invokeResult.getStatusCode());
            System.out.println(ans);
            //System.out.println(invokeResult.getPayload().array());

        } catch (ServiceException e) {
            System.out.println(e.getMessage());
        }


        System.out.println(invokeResult.getPayload());
    }


}
