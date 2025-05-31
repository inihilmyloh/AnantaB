package com.ananta.tablemodel;

import com.ananta.model.ModelBarang;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

public class TableModelBarang extends AbstractTableModel {

    private List<ModelBarang> list = new ArrayList<>();
    
    public ModelBarang getData(int index) {
        return list.get(index);
    }
    
    public void clear(){
        list.clear();
        fireTableDataChanged();
    }
    
    public void setData(List<ModelBarang> list) {
        clear();
        this.list.addAll(list);
        fireTableDataChanged();
    }
    
    public void insertData(ModelBarang barang) {
        list.add(barang);
        fireTableRowsInserted(list.size() - 1, list.size() - 1);
        JOptionPane.showMessageDialog(null, "Data Berhasil Ditambahkan");
    }
    
    public void updateData(int row, ModelBarang barang) {
        list.set(row, barang);
        fireTableDataChanged();
        JOptionPane.showMessageDialog(null, "Data Berhasil Diperbarui");
    }
    
    public void deleteData(int row) {
        list.remove(row);
        fireTableRowsDeleted(row, row);
        JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");
    }
    
    private final String[] columnNames = {"ID Barang", "Nama", "Barcode", "Jumlah", "Harga"};
    
    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ModelBarang model = list.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return model.getIdBarang();
            case 1:
                return model.getNama();
            case 2:
                return model.getBarcode();
            case 3:
                return model.getJumlah();
            case 4:
                return model.getHarga();
            default:
                return null;
        }
    }
    
    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }
}
