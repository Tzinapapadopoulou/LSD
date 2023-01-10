package test1;

import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.*;

public class Destination extends javax.swing.JFrame {
    ArrayList<Integer> tripDest = new ArrayList<Integer>();
    ArrayList<Integer> tripMonth = new ArrayList<Integer>();
    int position;
    public void setPosition(int a){
		position = a;
	}
    Scanner input = new Scanner(System.in);
    public void fillArrayList() {
        //μέθοδο που συμπληρώνει τα στοχεία του ταξιδιού του χρήστη που βρίσκεται στην θέση position//
        boolean continueLoop = true;
        int month = 0;
        do {
            try {
                //κάνουμε έλεγχο για το αν εισάγεται int //
                System.out.println("Enter month of your next trip :");
                month = input.nextInt();
                continueLoop = false;
            } catch (InputMismatchException e) {
                input.nextLine();
                System.out.println("Please enter an integer");
            }
        } while (continueLoop);
        checkMonth(month);
        tripMonth.add(position, month);
        System.out.println("Choose the destination of your next trip from the list above (Enter number)");
        continueLoop = true;
        int numOfDest = 0;
        do {
            try {
                //κάνουμε έλεγχο για το αν εισάγεται int //
                System.out.println("Enter number of your next destination :");
                numOfDest = input.nextInt();
                continueLoop = false;
            } catch (InputMismatchException e) {
                input.nextLine();
                System.out.println("Please enter an integer");
            }
        } while (continueLoop);
        checkDestination(numOfDest);
        tripDest.add(position, numOfDest);
    }
    public int checkMonth(int a) {
        //γίνεται έλεγχος εγκυρότητας του μήνα//
        if(a < 1 && a > 12) {
            do{
                System.out.println("invalid number of month, please try again");
                 a = input.nextInt();
            }while (a < 1 && a > 12);
        }
        return a;
    }
    public int checkDestination(int b) {
        //γίνεται έλεγχος εγκυρότητας του προορισμού//
        if(b < 1 && b > 20) {
            do {
              System.out.println("invalid number of destination, please try again");
              b = input.nextInt();
            }while (b < 1 && b > 20);
        }
        return b;
    }
    public void appearsTableOfDestinations () {
        String[] tableDest = new String[20];
        tableDest[0] = ("1.Athens");
        tableDest[1] = ("2.Paris");
        tableDest[2] = ("3.Rome");
        tableDest[3] = ("4.London");
        tableDest[4] = ("5.Barcelona");
        tableDest[5] = ("6.Prague");
        tableDest[6] = ("7.Vienna");
        tableDest[7] = ("8.Amsterdam");
        tableDest[8] = ("9.Budapest");
        tableDest[9] = ("10.Lisbon");
        tableDest[10] = ("11.Copenagen");
        tableDest[11] = ("12.Istanbul");
        tableDest[12] = ("13.Berlin");
        tableDest[13] = ("14.Stockholm");
        tableDest[14] = ("15.Dublin");
        tableDest[15] = ("16.Oslo");
        tableDest[16] = ("17.Milan");
        tableDest[17] = ("18.Bucharest");
        tableDest[18] = ("19.Moscow");
        tableDest[19] = ("20.Madrid");
        
    }

    public Destination() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setText("THERE ARE 20 DESTINATIONS\n1.Athens\n2.Paris\n3.Rome\n4.London\n5.Barcelona\n6.Prague\n7.Vienna\n8.Amsterdam\n9.Budapest\n10.Lisbon\n11.Copenhagen\n12.Istanbul\n13.Berlin\n14.Stockholm\n15.Dulin\n16.Oslo\n17.Milan\n18.Bucharest\n19.Moscow\n20.Madrid");
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(130, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MyFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MyFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MyFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MyFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MyFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
    
}
