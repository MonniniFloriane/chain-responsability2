public class Limite implements IService{
    private IService next = null;

    @Override
    public void setNext(IService next) {
        this.next = next;
    }

    @Override
    public void handleRequest(TransactionRequest request) {
        if (request.getType() == ETypeTransaction.LIMITE) {
            request.setConclusion("La transaction ne dépasse pas la limite autorisée");
        } else {
            if (request.getRequest() > 50) {
                request.setConclusion("La transaction dépasse la limite autorisée ! Echec");
            } if (next != null){
                next.handleRequest(request);
            }
        }
    }
}
