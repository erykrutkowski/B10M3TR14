/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biometria1;

import java.awt.Dimension;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import java.awt.Point;
import java.awt.event.MouseEvent;
import static java.awt.event.MouseEvent.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
/**
 *
 * @author antek
 */

public class ImageFrame extends javax.swing.JFrame {

    /**
     * Creates new form ImageFrame
     */
    public ImageFrame() {
        super("Biometria 1");
        initComponents();
        mouseCorBegin=null;
        mouseCorEnd=null;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        imageBoxer1 = new biometria1.ImageBoxer();
        imageBoxer2 = new biometria1.ImageBoxer();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        jMenu5.setText("jMenu5");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout imageBoxer1Layout = new javax.swing.GroupLayout(imageBoxer1);
        imageBoxer1.setLayout(imageBoxer1Layout);
        imageBoxer1Layout.setHorizontalGroup(
            imageBoxer1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 170, Short.MAX_VALUE)
        );
        imageBoxer1Layout.setVerticalGroup(
            imageBoxer1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout imageBoxer2Layout = new javax.swing.GroupLayout(imageBoxer2);
        imageBoxer2.setLayout(imageBoxer2Layout);
        imageBoxer2Layout.setHorizontalGroup(
            imageBoxer2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 170, Short.MAX_VALUE)
        );
        imageBoxer2Layout.setVerticalGroup(
            imageBoxer2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jMenu3.setText("File");

        jMenuItem1.setText("Open");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem1);

        jMenuItem2.setText("Save");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem2);

        jMenuItem3.setText("Close");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem3);

        jMenuBar2.add(jMenu3);

        jMenu4.setText("Zadanie");

        jMenuItem4.setText("Zadanie1");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem4);

        jMenuItem5.setText("Zadanie2");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem5);

        jMenuBar2.add(jMenu4);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imageBoxer1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(imageBoxer2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(imageBoxer2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(imageBoxer1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void imageBoxer1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imageBoxer1MouseClicked
        // TODO add your hanbdling code here:
        int b1 = MouseEvent.BUTTON1_DOWN_MASK;
        int b2 = MouseEvent.BUTTON2_DOWN_MASK;
        if (((evt.getModifiersEx() & (b1 | b2)) == b1)||(evt.getButton()==BUTTON1)) {
            if((evt.getX()>=0)&&(evt.getY()>=0)&&(evt.getX()<imageBoxer1.getWidth())&&(evt.getY()<imageBoxer1.getHeight())){
                //imageBoxer1.image.setRGB(evt.getX(), evt.getY(),Color.WHITE.getRGB());
                //imageBoxer1.repaint();
                colorFrame.setXY(evt.getX(),evt.getY());
            }
        }
        else{
            if(mouseCorBegin!=null){ 
                mouseCorEnd=evt.getPoint();
                imageBoxer1.setCorX((mouseCorBegin.x-mouseCorEnd.x));
                imageBoxer1.setCorY((mouseCorBegin.y-mouseCorEnd.y));
            }
            else{
                mouseCorBegin=evt.getPoint();
            }
        }

    }//GEN-LAST:event_imageBoxer1MouseClicked

    private void imageBoxer1MouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_imageBoxer1MouseWheelMoved
        // TODO add your handling code here:
        if(evt.getWheelRotation()>0){
            imageBoxer1.zoomInImage();
            mouseCorEnd=evt.getPoint();
            mouseCorBegin=new Point(evt.getPoint().x*2,evt.getPoint().y*2);
            imageBoxer1.setCorX((mouseCorBegin.x-mouseCorEnd.x));
            imageBoxer1.setCorY((mouseCorBegin.y-mouseCorEnd.y));
            imageBoxer1.saveCor();
            mouseCorBegin=null;
            mouseCorEnd=null;
        }
        else{
            imageBoxer1.zoomOutImage();
            mouseCorEnd=evt.getPoint();
            mouseCorBegin=new Point(evt.getPoint().x/2,evt.getPoint().y/2);
            imageBoxer1.setCorX((mouseCorBegin.x-mouseCorEnd.x));
            imageBoxer1.setCorY((mouseCorBegin.y-mouseCorEnd.y));
            imageBoxer1.saveCor();
            mouseCorBegin=null;
            mouseCorEnd=null;

        }
        repaint();
    }//GEN-LAST:event_imageBoxer1MouseWheelMoved

    private void imageBoxer1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imageBoxer1MouseReleased
        imageBoxer1.saveCor();
        mouseCorBegin=null;
        mouseCorEnd=null;
        
    }//GEN-LAST:event_imageBoxer1MouseReleased

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        fc=new JFileChooser();
         FileFilter filter = new FileNameExtensionFilter("JPEG/GIF/TIF file", "jpg", "jpeg", "gif", "tif");
         fc.setFileFilter(filter);
         int returnVal=fc.showOpenDialog(null);

                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    File imageFile = fc.getSelectedFile();
                    		try {
                                    imageBoxer1.image = ImageIO.read(imageFile);
                                    imageBoxer2.image = ImageIO.read(imageFile);                                    
                                } catch (IOException e) {
                                        System.err.println("Blad odczytu obrazka");
                                        e.printStackTrace();
                                }
                    Dimension dimension = new Dimension(imageBoxer1.image.getWidth(), imageBoxer1.image.getHeight());
                    imageBoxer1.setPreferredSize(dimension);
                    imageBoxer1.setSize(dimension);
                    imageBoxer2.setPreferredSize(dimension);
                    imageBoxer2.setSize(dimension);
                    imageBoxer2.repaint();
                    imageBoxer1.repaint();
                    this.pack();
     
                        
                } 
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        fc=new JFileChooser();
         FileFilter filter = new FileNameExtensionFilter("JPEG/GIF/TIF file", "jpg", "jpeg", "gif", "tif");
         fc.setFileFilter(filter);
         int returnVal=fc.showSaveDialog(null);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    
                    File imageFile = fc.getSelectedFile();
                    		try {
                                    if(!((imageFile.getName().toLowerCase().endsWith(".jpg"))||(imageFile.getName().toLowerCase().endsWith(".jpeg")||(imageFile.getName().toLowerCase().endsWith(".tif"))||(imageFile.getName().toLowerCase().endsWith(".gif"))))){
                                        imageFile=new File(imageFile.getAbsolutePath()+".jpg");
                                    }
                                    
                                    if(imageBoxer1.image!=null) ImageIO.write(imageBoxer1.image, imageFile.getName().toLowerCase().substring(imageFile.getName().length()-3), imageFile);
                                } catch (IOException e) {
                                        System.err.println("Blad zapisu obrazka");
                                        e.printStackTrace();
                                }
     
                        
                } 
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        
        colorFrame = new ColorFrame(imageBoxer1);
        colorFrame.setVisible(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
        histogramFrame = new HistogramFrame(imageBoxer1);
        histogramFrame.setVisible(true);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

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
            java.util.logging.Logger.getLogger(ImageFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ImageFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ImageFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ImageFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ImageFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private biometria1.ImageBoxer imageBoxer1;
    private biometria1.ImageBoxer imageBoxer2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    // End of variables declaration//GEN-END:variables
    private File imageFile;
    private JFileChooser fc;
    private ColorFrame colorFrame;
    private HistogramFrame histogramFrame;
    private Point mouseCorBegin;
    private Point mouseCorEnd;
}
