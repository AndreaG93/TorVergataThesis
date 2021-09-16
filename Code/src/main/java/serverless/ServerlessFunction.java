package serverless;


public abstract class ServerlessFunction extends ServerlessObject {

    protected ServerlessFunction(int id) {
        super(id);
    }

    public abstract float getMaxUsableMemorySize();

    public abstract float getUsedMemorySize();

    public abstract void setMaxUsableMemorySize(float memorySize);
}
