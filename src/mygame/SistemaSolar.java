/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;

import com.jme3.app.SimpleApplication;
import com.jme3.material.Material;
import com.jme3.math.FastMath;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import com.jme3.scene.shape.Sphere;
import com.jme3.system.AppSettings;

/**
 *
 * @author Paulina Rodriguez
 */
public class SistemaSolar extends SimpleApplication{

    public Spatial orbitaMercurio;
    public Spatial rotacionMercurio;
    public Spatial orbitaVenus;
    public Spatial rotacionvenus;
    public Spatial orbitaTierra;
    public Spatial rotacionTierra;
    public Spatial orbitaMarte;
    public Spatial rotacionMarte;
    public Spatial orbitaJupiter;
    public Spatial rotacionJupiter;
    
    public static void main (String[] args){
        SistemaSolar app = new SistemaSolar();
        
        AppSettings settings = new AppSettings(true);
        settings.setFrameRate(60);
        app.setSettings(settings);
        app.start();
    }
    @Override
    public void simpleInitApp() {
    
        flyCam.setMoveSpeed(90f);
        
        Node centroSolarN = new Node("CentroSolar");
        Node traslacionMercurioN = new Node("TraslacionMercurio");
        Node rotacionMercurioN = new Node("RotacionMercurio");
        
        Node traslacionVenusN = new Node("TraslacionVenus");
        Node rotacionVenusN = new Node("RotacionVenus");
        
        Node traslacionTierraN = new Node("TraslacionTierra");
        Node rotacionTierraN = new Node("RotacionTiera");
        
        Node traslacionMarteN = new Node("TraslacionMarte");
        Node rotacionMarteN = new Node("RotacionMarte");
        
        Node traslacionJupiterN = new Node("TraslacionJupiter");
        Node rotacionJupiterN = new Node("RotacionJupiter");
        
        Sphere sol = new Sphere(30,30,10);
        Geometry solgeo = new Geometry("sol", sol);
        solgeo.rotate(30, 0, 0);
        
        Material matSol = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        matSol.setTexture("ColorMap", assetManager.loadTexture("Textures/sol.jpg"));
        solgeo.setMaterial(matSol);
        
        Sphere mercurio = new Sphere(30,30,1);
        Geometry mercurioGeo = new Geometry("mercurio", mercurio);
        mercurioGeo.rotate(30, 0, 0);
        
        Material matMercurio = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        matMercurio.setTexture("ColorMap", assetManager.loadTexture("Textures/mercurio.jpg"));
        mercurioGeo.setMaterial(matMercurio);
        
        Sphere venus = new Sphere(30, 30, 3);
        Geometry venusGeo = new Geometry("venus", venus);
        venusGeo.rotate(30, 0, 0);
        
        Material matVenus = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        matVenus.setTexture("ColorMap", assetManager.loadTexture("Textures/venus.jpg"));
        venusGeo.setMaterial(matVenus);
        
        Sphere tierra = new Sphere(30,30,3);
        Geometry tierraGeo = new Geometry("tierra", tierra);
        tierraGeo.rotate(30, 0, 0);
        
        Material matTierra = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        matTierra.setTexture("ColorMap", assetManager.loadTexture("Textures/tierra.jpg"));
        tierraGeo.setMaterial(matTierra);
       
        Sphere marte = new Sphere(30,30,2);
        Geometry marteGeo = new Geometry("marte", marte);
        marteGeo.rotate(30, 0, 0);
        
        Material matMarte = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        matMarte.setTexture("ColorMap", assetManager.loadTexture("Textures/marte.jpg"));
        marteGeo.setMaterial(matMarte);
        
        Sphere jupiter = new Sphere(30,30,6);
        Geometry jupiterGeo = new Geometry("jupiter", jupiter);
        jupiterGeo.rotate(30, 0, 0);
        
        Material matJupiter = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        matJupiter.setTexture("ColorMap", assetManager.loadTexture("Textures/jupiter.jpg"));
        jupiterGeo.setMaterial(matJupiter);
        
        
        rootNode.attachChild(centroSolarN);
        centroSolarN.attachChild(solgeo);
        
        centroSolarN.attachChild(traslacionMercurioN);
        traslacionMercurioN.attachChild(rotacionMercurioN);
        rotacionMercurioN.attachChild(mercurioGeo);
        rotacionMercurioN.move(15, 0, 0);
        
        centroSolarN.attachChild(traslacionVenusN);
        traslacionVenusN.attachChild(rotacionVenusN);
        rotacionVenusN.attachChild(venusGeo);
        rotacionVenusN.move(35, 0, 0);
        
        centroSolarN.attachChild(traslacionTierraN);
        traslacionTierraN.attachChild(rotacionTierraN);
        rotacionTierraN.attachChild(tierraGeo);
        rotacionTierraN.move(55, 0, 0);
        
        centroSolarN.attachChild(traslacionMarteN);
        traslacionMarteN.attachChild(rotacionMarteN);
        rotacionMarteN.attachChild(marteGeo);
        rotacionMarteN.move(75, 0, 0);
        
        centroSolarN.attachChild(traslacionJupiterN);
        traslacionJupiterN.attachChild(rotacionJupiterN);
        rotacionJupiterN.attachChild(jupiterGeo);
        rotacionJupiterN.move(95, 0, 0);
        
        
    }
    @Override
    public void simpleUpdate(float tpf){
        
        if(rotacionMercurio == null && orbitaMercurio == null){
            rotacionMercurio = rootNode.getChild("RotacionMercurio");
            orbitaMercurio = rootNode.getChild("TraslacionMercurio");
        }
        else{
            rotacionMercurio.rotate(0, FastMath.DEG_TO_RAD*0.11f, 0);
            orbitaMercurio.rotate(0, FastMath.DEG_TO_RAD*1.2f, 0);
        }      
        
        if(rotacionvenus == null && orbitaVenus == null){
            rotacionvenus = rootNode.getChild("RotacionVenus");
            orbitaVenus = rootNode.getChild("TraslacionVenus");
        }
        else{
            rotacionvenus.rotate(0, FastMath.DEG_TO_RAD*0.07f, 0);
            orbitaVenus.rotate(0, FastMath.DEG_TO_RAD*0.75f, 0);
        }
        
        if(rotacionTierra == null && orbitaTierra == null){
            rotacionTierra = rootNode.getChild("RotacionTiera");
            orbitaTierra = rootNode.getChild("TraslacionTierra");
        }
        else{
            rotacionTierra.rotate(0, FastMath.DEG_TO_RAD*1, 0);
            orbitaTierra.rotate(0, FastMath.DEG_TO_RAD*1, 0);
        }
        
        if(rotacionMarte == null && orbitaMarte == null){
            rotacionMarte = rootNode.getChild("RotacionMarte");
            orbitaMarte = rootNode.getChild("TraslacionMarte");
        }
        else{
            rotacionMarte.rotate(0, FastMath.DEG_TO_RAD*1, 0);
            orbitaMarte.rotate(0, FastMath.DEG_TO_RAD*0.5f, 0);
        }
        
        if(rotacionJupiter == null && orbitaJupiter == null){
            rotacionJupiter = rootNode.getChild("RotacionJupiter");
            orbitaJupiter = rootNode.getChild("TraslacionJupiter");
        }
        else{
            rotacionJupiter.rotate(0, FastMath.DEG_TO_RAD*1.5f, 0);
            orbitaJupiter.rotate(0, FastMath.DEG_TO_RAD*0.08f, 0);
        }
    }
    
}
