/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biometria1;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/**
 *
<<<<<<< HEAD
 * @author antek
=======
 * @author rryk
>>>>>>> origin/master
 */
public class ImageBoxer extends javax.swing.JPanel {

    /**
     * Creates new form ImagePanel
     */
    public BufferedImage image;
    public int scale;
    private int corX,tempcorX;
    private int corY,tempcorY;
    public Graphics2D g2d;
    public ImageBoxer() {
          scale=1;
          corX=0;
          corY=0;
          tempcorX=0;
          tempcorY=0;
    }
    public int getCorX(){return corX;}
    public void setCorX(int x){
        x=x/(scale);
        float maxcorx;
        if(scale==1){
            maxcorx=image.getWidth()-this.getSize().width;
            if (maxcorx<0) maxcorx=0;
        }
        else{
            maxcorx=1;
            for(int i=scale/2; i>1; i=i/2){maxcorx+=(1/(float)i);}
            maxcorx*=(image.getWidth()/2);
            maxcorx-=(float)(this.getSize().width-image.getWidth())/(float)2;
        }
        if((corX+x<=maxcorx)&&(corX+x>=0)) tempcorX=x;
        else if(corX+x>maxcorx) tempcorX=(int)maxcorx-corX;
        else if(corX+x<0) tempcorX=corX*-1;
        repaint();
    }
    public int getCorY(){return corY;}
    public void saveCor(){
        corX+=tempcorX;
        corY+=tempcorY;
        tempcorX=0;
        tempcorY=0;
    }
    public void setCorY(int y){
        y=y/(scale);
        float maxcory;
        if(scale==1){
            maxcory=image.getHeight()-this.getSize().height;
            if (maxcory<0) maxcory=0;
        }
        else{
            maxcory=1;
            for(int i=scale/2; i>1; i=i/2){maxcory+=(1/(float)i);}
            maxcory*=(image.getHeight()/2);
            maxcory-=(float)(this.getSize().height-image.getHeight())/(float)2;
        }
        if((corY+y<=maxcory)&&(corY+y>=0)) tempcorY=y;
        else if(corY+y>maxcory) tempcorY=(int)maxcory-corY;
        else if(corY+y<0) tempcorY=corY*-1;
        repaint();
    }
    public void zoomInImage(){
        if (scale<8){
            scale*=2;
            repaint();
        }
    }
    public void zoomOutImage(){
        if (scale>1){
            scale/=2;
            repaint();
        }
    }    
	@Override
	public void paintComponent(Graphics g) {
		g2d = (Graphics2D) g;
                g2d.scale(scale, scale);
		g2d.drawImage(image, 0-(corX+tempcorX), 0-(corY+tempcorY), this);
	}
                
}

