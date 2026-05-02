package ShopExpress;

public class GestionPaiement {

    public double effectuerPaiement(double montant, double solde) {
        if (montant <= 0) {
            throw new IllegalArgumentException("Le montant doit être supérieur à zéro.");
        }
        if (montant > solde) {
            throw new IllegalArgumentException("Solde insuffisant pour cet achat.");
        }
        
        return solde - montant; 
    }

    public double lireMontant(String valeur) throws NumberFormatException, IllegalArgumentException {
        double montant = Double.parseDouble(valeur);
        
        if (montant < 0) {
            throw new IllegalArgumentException("Le montant ne peut pas être négatif.");
        }
        return montant;
    }

    public double lireTransaction(double[] tab, int index) {
            return tab[index]; 
        }
    public static void main(String[] args) {
    	GestionPaiement shop = new GestionPaiement();

        System.out.println(" ---------Partie 1 & 3----------");
        try {
            double montantSaisi = shop.lireMontant("100.0"); 
            double nouveauSolde = shop.effectuerPaiement(montantSaisi, 200.0); 
            System.out.println("Transaction réussie. Nouveau solde : " + nouveauSolde);
        } catch (NumberFormatException e) {
            System.out.println("Erreur technique : Format de nombre invalide."); 
        } catch (IllegalArgumentException e) {
            System.out.println("Erreur métier : " + e.getMessage()); 
        } finally {
            System.out.println("Fin de la transaction"); 
        }

        System.out.println(" ---------  test Partie 4 ----------");
        try {
            double[] transactions = {50.0, 120.5}; 
            System.out.println("Transaction index 1 : " + shop.lireTransaction(transactions, 1));
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Erreur : Indice de transaction invalide."); 
        } catch (NullPointerException e) {
            System.out.println("Erreur : Liste de transactions non initialisée.");
        }
    }
}
