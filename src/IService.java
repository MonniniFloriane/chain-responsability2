public interface IService {
    void setNext(IService next);
    void handleRequest(TransactionRequest request);
}
