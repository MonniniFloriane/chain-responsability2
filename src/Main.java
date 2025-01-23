public class Main {
    /*
    Exercice : Validation de Transactions Bancaires avec la Chaîne de Responsabilité
      Contexte :
      Dans une application bancaire, une transaction financière doit passer par plusieurs étapes de validation avant d'être approuvée. Voici les règles de validation :
            - Validation du solde : vérifier si le compte source a suffisamment de fonds pour effectuer la transaction.
            - Validation de la limite journalière : vérifier si la transaction ne dépasse pas la limite autorisée pour un utilisateur donné.
            - Validation de sécurité : vérifier si la transaction est effectuée à partir d'une adresse IP autorisée.

     Objectif :
      Implémentez un système basé sur le design pattern Chain of Responsibility pour valider les transactions dans cet ordre. Si une étape échoue, la transaction est refusée et un message explicite est retourné. Sinon, la transaction est validée et effectuée.
      Afficher le solde avant et après.
     */
    public static void main(String[] args) {
        IService solde = new Solde();
        IService limit = new Limite();
        IService secu = new Securiter();

        solde.setNext(limit);
        limit.setNext(secu);

        TransactionRequest requestA = new TransactionRequest(ETypeTransaction.SOLDE, 0);
        TransactionRequest requestB = new TransactionRequest(ETypeTransaction.LIMITE, 60);
        TransactionRequest requestC = new TransactionRequest(ETypeTransaction.SECURITE, 102);

        solde.handleRequest(requestA);
        solde.handleRequest(requestB);
        solde.handleRequest(requestC);

        System.out.println(requestA.getConclusion());
        System.out.println(requestB.getConclusion());
        System.out.println(requestC.getConclusion());
    }
}