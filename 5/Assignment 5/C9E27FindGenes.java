import javax.swing.JOptionPane;

public class C9E27FindGenes {
    public static void main(String[] args)  {

        // read in data
        String start = "ATG";
        String stop1  = "TAG";
        String stop2  = "TAA";
        String stop3  = "TGA";
        
        String gene = null;

        // find genes
       
       
        int option = JOptionPane.YES_OPTION;
        while(option == JOptionPane.YES_OPTION){
        	 int beg = -1;
        	 int index = 0;
        	 int j = 0;
        	String genome = JOptionPane.showInputDialog("Enter a genome series string: ");
	        for (int i = 0; i < genome.length() - 2; i++) {
	            String codon = genome.substring(i, i+3);
	
	            // start codon
	            if (codon.equals(start)) beg = i;
	
	            // stop codon
	            if ((codon.equals(stop1)||codon.equals(stop2)||codon.equals(stop3)) && (beg != -1) && (beg + 3 < i)) {
	                
	                 gene = genome.substring(beg+3, i);
	                if (gene.length() % 3 == 0) {
	                    beg = -1;
	                    index = 1;
	                    //gene[j+1] = "      ";
	                   
	                    JOptionPane.showMessageDialog(null,"One of genes: " + gene);
	                    j++;
	                    j++;
	                }
	            }
	        }
	       if(index == 0) {
	    	   JOptionPane.showMessageDialog(null,"There is not any gene in the genome string .");
	       }
	 
	    option = JOptionPane.showConfirmDialog(null, "Do you want to enter another genome string ?");
        }
    }
}
