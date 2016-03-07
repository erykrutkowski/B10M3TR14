/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biometria1;

/**
 *
 * @author antek
 */
public class ColorFrame extends javax.swing.JFrame {

    /**
     * Creates new form ColorFrame
     */
    public ColorFrame(ImageBoxer Boxer) {
        super("ColorChooser");
        initComponents();
        imageBoxer = Boxer;
        isChanging=false;
    }
    public void setXY(int x, int y){
        if(!isChanging){
            if(getButton.isSelected()){
                isChanging=true;
                xSpinner.setValue((Integer)(x/imageBoxer.scale));
                ySpinner.setValue((Integer)(y/imageBoxer.scale));
                isChanging=false;
                jColorChooser1.setColor(imageBoxer.image.getRGB((x/imageBoxer.scale)+imageBoxer.getCorX(), (y/imageBoxer.scale)+imageBoxer.getCorY()));
            }
            else{
                isChanging=true;
                xSpinner.setValue((Integer)(x/imageBoxer.scale));
                ySpinner.setValue((Integer)(y/imageBoxer.scale));
                isChanging=false;
                imageBoxer.image.setRGB((x/imageBoxer.scale)+imageBoxer.getCorX(), (y/imageBoxer.scale)+imageBoxer.getCorY(), jColorChooser1.getColor().getRGB());
                imageBoxer.repaint();
            }
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        modeGroup = new javax.swing.ButtonGroup();
        jColorChooser1 = new javax.swing.JColorChooser();
        xLabel = new javax.swing.JLabel();
        yLabel = new javax.swing.JLabel();
        xSpinner = new javax.swing.JSpinner();
        ySpinner = new javax.swing.JSpinner();
        getButton = new javax.swing.JRadioButton();
        setButton = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        xLabel.setText("x:");

        yLabel.setText("y:");

        xSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                xSpinnerStateChanged(evt);
            }
        });

        ySpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                xSpinnerStateChanged(evt);
            }
        });

        modeGroup.add(getButton);
        getButton.setSelected(true);
        getButton.setText("GET");
        getButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setButtonActionPerformed(evt);
            }
        });

        modeGroup.add(setButton);
        setButton.setText("SET");
        setButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(getButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(setButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(xLabel)
                .addGap(40, 40, 40)
                .addComponent(xSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(yLabel)
                .addGap(4, 4, 4)
                .addComponent(ySpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
            .addComponent(jColorChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, 565, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(xSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ySpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(yLabel)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(xLabel)
                        .addComponent(getButton)
                        .addComponent(setButton)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jColorChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void SpinnerModifier(){
        if(((Integer)xSpinner.getValue()<=imageBoxer.image.getWidth())&&((Integer)ySpinner.getValue()<=imageBoxer.image.getHeight())){
            setXY((Integer) xSpinner.getValue()*imageBoxer.scale,(Integer) ySpinner.getValue()*imageBoxer.scale);
        }
    }
    private void xSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_xSpinnerStateChanged
        // TODO add your handling code here:
        SpinnerModifier();
    }//GEN-LAST:event_xSpinnerStateChanged

    private void setButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setButtonActionPerformed
        SpinnerModifier();
    }//GEN-LAST:event_setButtonActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton getButton;
    private javax.swing.JColorChooser jColorChooser1;
    private javax.swing.ButtonGroup modeGroup;
    private javax.swing.JRadioButton setButton;
    private javax.swing.JLabel xLabel;
    private javax.swing.JSpinner xSpinner;
    private javax.swing.JLabel yLabel;
    private javax.swing.JSpinner ySpinner;
    // End of variables declaration//GEN-END:variables
    private final ImageBoxer imageBoxer;
    private boolean isChanging;
}