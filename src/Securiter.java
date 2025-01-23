public class Securiter implements IService {
    private IService next = null;

    @Override
    public void setNext(IService next) {
        this.next = next;
    }

    @Override
    public void handleRequest(TransactionRequest request) {
        if (request.getType() == ETypeTransaction.SECURITE) {
            request.setConclusion("Votre IP est valide");
        } else {
            if (request.getRequest() != 192.168) {
                request.setConclusion("Votre IP n'est pas valide ! Echec");
            } if (next != null){
                next.handleRequest(request);
            }
        }
    }
}
