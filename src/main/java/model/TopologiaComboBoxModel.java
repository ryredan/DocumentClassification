/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

/**
 *
 * @author User
 */
public class TopologiaComboBoxModel extends AbstractListModel<Object> implements ComboBoxModel<Object>{
    ArrayList<TopologiaTModel> values;
    TopologiaTModel selected;
    ArrayList<ListDataListener> listeners = new ArrayList<>();

    public TopologiaComboBoxModel(ArrayList<TopologiaTModel> v) {
        this.values = v;
    }

    @Override
    public int getSize() {
        return this.values.size();
    }

    @Override
    public Object getElementAt(int index) {
        return this.values.get(index);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        this.selected = (TopologiaTModel) anItem;
    }

    @Override
    public Object getSelectedItem() {
        return this.selected;
    }
    
}
