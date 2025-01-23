public class TransactionRequest {
    private ETypeTransaction type;
    private int request       = 0;
    private String conclusion = "";

    public TransactionRequest(ETypeTransaction type, int request) {
        this.type    = type;
        this.request = request;
    }

    public ETypeTransaction getType() {
        return type;
    }

    public int getRequest() {
        return request;
    }

    public String getConclusion() {
        return conclusion;
    }

    public void setConclusion(String conclusion) {
        this.conclusion = conclusion;
    }
}
