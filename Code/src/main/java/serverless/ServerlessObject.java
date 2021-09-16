package serverless;

import org.json.JSONObject;

public abstract class ServerlessObject {

    public final int id;

    protected ServerlessObject(int id) {
        this.id = id;
    }

    public abstract JSONObject execute(JSONObject input);

    public abstract float getExecutionTime();

    public abstract float getBilledTime();
}
