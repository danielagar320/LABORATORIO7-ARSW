/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.blueprints.persistence.impl;

import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.model.Point;
import edu.eci.arsw.blueprints.persistence.BlueprintNotFoundException;
import edu.eci.arsw.blueprints.persistence.BlueprintPersistenceException;
import edu.eci.arsw.blueprints.persistence.BlueprintsPersistence;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import edu.eci.arsw.blueprints.model.Point;
import edu.eci.arsw.blueprints.persistence.BlueprintNotFoundException;
import edu.eci.arsw.blueprints.persistence.BlueprintPersistenceException;
import edu.eci.arsw.blueprints.persistence.BlueprintsPersistence;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 *
 * @author hcadavid
 */
@Service
public class InMemoryBlueprintPersistence implements BlueprintsPersistence{

    private final ConcurrentHashMap<Tuple<String,String>,Blueprint> blueprints=new ConcurrentHashMap<>();

    public InMemoryBlueprintPersistence() {
        //load stub data
        Point[] pts0=new Point[]{new Point(140, 140),new Point(115, 115)};
        Blueprint bp0=new Blueprint("Juan", "Prueba1",pts0);
        blueprints.put(new Tuple<>(bp0.getAuthor(),bp0.getName()), bp0);
        Point[] pts1=new Point[]{new Point(24, 86),new Point(12, 118)};
        Blueprint bp1=new Blueprint("Daniela", "Prueba2",pts1);
        blueprints.put(new Tuple<>(bp1.getAuthor(),bp1.getName()), bp1);
        Point[] pts2=new Point[]{new Point(32, 17),new Point(54, 86)};
        Blueprint bp2=new Blueprint("Edwar", "Prueba3",pts2);
        blueprints.put(new Tuple<>(bp2.getAuthor(),bp2.getName()), bp2);
        Point[] pts3=new Point[]{new Point(342, 1),new Point(2, 343)};
        Blueprint bp3=new Blueprint("Lab05", "Prueba4",pts3);
        blueprints.put(new Tuple<>(bp3.getAuthor(),bp3.getName()), bp3);

    }

    @Override
    public void saveBlueprint(Blueprint bp) throws BlueprintPersistenceException {
        if (blueprints.containsKey(new Tuple<>(bp.getAuthor(),bp.getName()))){
            throw new BlueprintPersistenceException("The given blueprint already exists: "+bp);
        }
        else{
            blueprints.put(new Tuple<>(bp.getAuthor(),bp.getName()), bp);
        }        
    }

    @Override
    public Blueprint getBlueprint(String author, String bprintname) throws BlueprintNotFoundException {
        return blueprints.get(new Tuple<>(author, bprintname));
    }

    @Override
    public Set<Blueprint> getBlueprintsByAuthor(String author) throws BlueprintNotFoundException{
        Set<Blueprint> bpba = new HashSet<>();
        Set<Tuple<String, String>> keys = blueprints.keySet();
        for(Tuple<String, String> i : keys){
            if(i.getElem1().equals(author)){
                bpba.add(blueprints.get(i));
            }
        }
        return bpba;
    }

    @Override
    public Set<Blueprint> getAllBlueprints() throws BlueprintNotFoundException {
        Set<Blueprint> bpba = new HashSet<>();
        Set<Tuple<String, String>> keys = blueprints.keySet();
        for(Tuple<String, String> i : keys){
                bpba.add(blueprints.get(i));
        }
        return bpba;
    }

    @Override
    public void updatePoints(String author, String bpname, List<Point> points) {
        Blueprint b = blueprints.get(new Tuple<>(author, bpname));
        b.addPoint(points.get(0));
    }

    @Override
    public void deleteBlueprint(String author, String bpname) {
        blueprints.remove(new Tuple<>(author, bpname));
    }


}