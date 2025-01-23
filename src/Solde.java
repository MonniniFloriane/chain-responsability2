public class Solde implements IService{
    private IService next = null;

    @Override
    public void setNext(IService next) {
        this.next = next;
    }

    @Override
    public void handleRequest(TransactionRequest request) {
        if (request.getType() == ETypeTransaction.SOLDE) {
            request.setConclusion("Votre solde à asser de fond");
        } else {
            if (request.getRequest() != 0) {
                request.setConclusion("Votre solde est vide ! Echec");
            } if (next != null){
                next.handleRequest(request);
            }
        }
    }
}
