package serverless.aws;

import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.lambda.AWSLambda;
import com.amazonaws.services.lambda.AWSLambdaAsyncClient;
import com.amazonaws.services.lambda.AWSLambdaClient;
import com.amazonaws.services.lambda.AWSLambdaClientBuilder;
import com.amazonaws.services.lambda.model.*;

import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.List;

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

    public void list() {

        ListFunctionsResult functionResult = null;

        try {
            AWSLambda awsLambda = AWSLambdaClientBuilder.standard()
                    .withCredentials(new ProfileCredentialsProvider())
                    .withRegion(Regions.US_EAST_1).build();

            functionResult = awsLambda.listFunctions();

            List<FunctionConfiguration> list = functionResult.getFunctions();

            for (Iterator iter = list.iterator(); iter.hasNext(); ) {
                FunctionConfiguration config = (FunctionConfiguration) iter.next();

                List<FileSystemConfig> systemConfigList = config.getFileSystemConfigs();
                for (Iterator myIter = systemConfigList.iterator(); myIter.hasNext(); ) {
                    FileSystemConfig fileSystemConfig = (FileSystemConfig) myIter.next();

                    System.out.println(fileSystemConfig.toString());
                }

                System.out.println("The function name is " + config.getFunctionName());
            }

        } catch (ServiceException e) {
            System.out.println(e);
        }
    }


    public void updateMemorySize(int memorySize) {

        UpdateFunctionConfigurationRequest request = new UpdateFunctionConfigurationRequest();
        request.setFunctionName(this.functionName);
        request.setMemorySize(memorySize);

        try {
            AWSLambda awsLambda = AWSLambdaClientBuilder.standard()
                    .withCredentials(new ProfileCredentialsProvider())
                    .withRegion(Regions.US_EAST_1).build();

            UpdateFunctionConfigurationResult result = awsLambda.updateFunctionConfiguration(request);

            System.out.println(result.getMemorySize());


        } catch (ServiceException e) {
            System.out.println(e);
        }
    }
}
