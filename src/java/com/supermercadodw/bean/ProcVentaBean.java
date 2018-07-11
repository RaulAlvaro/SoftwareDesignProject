/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supermercadodw.bean;

import com.supermercadodw.dao.ClienteDAO;
import com.supermercadodw.dao.DetalleVentaDAO;
import com.supermercadodw.dao.PersonalDAO;
import com.supermercadodw.dao.ProductoDAO;
import com.supermercadodw.dao.VentaDAO;
import com.supermercadodw.entidades.Cliente;
import com.supermercadodw.entidades.DetalleVenta;
import com.supermercadodw.entidades.Personal;
import com.supermercadodw.entidades.Producto;
import com.supermercadodw.entidades.Venta;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.CellEditEvent;

/**
 *
 * @author raul
 */
@ManagedBean
@ViewScoped
public class ProcVentaBean {

    private Personal personal;
    private Cliente cliente;
    private Venta venta;
    private Producto producto;
    private DetalleVenta detalleVenta;
    private List<DetalleVenta> listaDetalleVenta;
    private List<Producto> listaProductos;

    private PersonalDAO personalDAO;
    private ClienteDAO clienteDAO;
    private VentaDAO ventaDAO;
    private ProductoDAO productoDAO;
    private DetalleVentaDAO detalleVentaDAO;

    private String nombreProductoBuscar;
    private List<String> listanombreProductos;
    private List<String> results;

    @PostConstruct
    private void init() {
        initInstancia();
        cargarProductos();
    }

    private void initInstancia() {
        personal = new Personal();
        cliente = new Cliente();
        venta = new Venta();
        producto = new Producto();
        detalleVenta = new DetalleVenta();
        listaDetalleVenta = new ArrayList<>();
        listaProductos = new ArrayList<>();
        personalDAO = new PersonalDAO();
        clienteDAO = new ClienteDAO();
        ventaDAO = new VentaDAO();
        productoDAO = new ProductoDAO();
        detalleVentaDAO = new DetalleVentaDAO();
        listanombreProductos = new ArrayList<>();
        results = new ArrayList<>();
    }

    public void cargarProductos() {
        listaProductos = productoDAO.ListarProductos();
        for (Producto productoi : listaProductos) {
            listanombreProductos.add(productoi.getNombreProducto());
        }
    }

    public List<String> completeProduct(String query) {
        results.clear();
        for (String result : listanombreProductos) {
            boolean agregarProducto = false;
            for (int i = 0; i < query.length(); i++) {
                if (query.charAt(i) == result.charAt(i)) {
                    agregarProducto = true;
                } else {
                    agregarProducto = false;
                }
            }
            if (agregarProducto) {
                results.add(result);
            }
        }
        return results;
    }

    public void addDetalleVenta() {
        int cantidad = 1;
        DetalleVenta detVenta = new DetalleVenta();
        for (Producto productoi : listaProductos) {
            if (nombreProductoBuscar.equals(productoi.getNombreProducto())) {
                detVenta.setIdDetalleVenta(0);
                detVenta.setProducto(productoi);
                detVenta.setCantidadProductoVenta(cantidad);
                detVenta.setMontoFinalProductoVenta(productoi.getPrecioProducto() * cantidad);
            }
        }
        listaDetalleVenta.add(detVenta);
    }

    public Float getmontoFinalVenta() {
        Float montofinal = 0f;
        for (DetalleVenta detalleVentai : listaDetalleVenta) {
            montofinal = montofinal + detalleVentai.getMontoFinalProductoVenta();
        }
        return montofinal;
    }

    public void onCellEdit(CellEditEvent event) {

        System.out.println(event.getOldValue());
        System.out.println((Integer) event.getNewValue());
        System.out.println(event.getRowIndex());

        listaDetalleVenta.get(event.getRowIndex()).setCantidadProductoVenta((Integer) event.getNewValue());
        Float precio = listaDetalleVenta.get(event.getRowIndex()).getProducto().getPrecioProducto();
        listaDetalleVenta.get(event.getRowIndex()).setMontoFinalProductoVenta(precio * (Integer) event.getNewValue());

        /*
        DetalleVenta detalleVentaold = (DetalleVenta) event.getOldValue();
        DetalleVenta detalleVentanew = (DetalleVenta) event.getNewValue();
        
        FacesContext context = FacesContext.getCurrentInstance(); 
        context.addMessage(null, new FacesMessage("Successful",  "Your message: " + "ALVVV") );
        
        if(detalleVentanew != null && !detalleVentanew.equals(detalleVentaold)) {
            for (DetalleVenta detalleVenta1 : listaDetalleVenta) {
                if (detalleVentaold.getProducto().getIdProducto().equals(detalleVenta1.getProducto().getIdProducto())) {
                    detalleVenta1.setCantidadProductoVenta(detalleVentanew.getCantidadProductoVenta());
                    System.out.println("precio nuevo es: " + detalleVentanew.getCantidadProductoVenta());
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Update Montofinal", 
                            detalleVentanew.getCantidadProductoVenta().toString()));
                    
                    
                    detalleVenta1.setMontoFinalProductoVenta(detalleVentanew.getCantidadProductoVenta()*detalleVentanew.getProducto().getPrecioProducto());
                    System.out.println("el monto final es: " + detalleVenta1.getMontoFinalProductoVenta());
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Update Montofinal", 
                            detalleVenta1.getMontoFinalProductoVenta().toString()));

                }
            }
        }
        //return "/Procesos/FormProcRegistroVenta";
         */
    }

    public void imprimirDetalle() {
        for (DetalleVenta detalleVenta1 : listaDetalleVenta) {
            System.out.println(detalleVenta1.getProducto().getNombreProducto());
            System.out.println(detalleVenta1.getCantidadProductoVenta());
            System.out.println(detalleVenta1.getMontoFinalProductoVenta());
        }
    }

    public Personal getPersonal() {
        return personal;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public DetalleVenta getDetalleVenta() {
        return detalleVenta;
    }

    public void setDetalleVenta(DetalleVenta detalleVenta) {
        this.detalleVenta = detalleVenta;
    }

    public List<DetalleVenta> getListaDetalleVenta() {
        return listaDetalleVenta;
    }

    public void setListaDetalleVenta(List<DetalleVenta> listaDetalleVenta) {
        this.listaDetalleVenta = listaDetalleVenta;
    }

    public List<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(List<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public String getNombreProductoBuscar() {
        return nombreProductoBuscar;
    }

    public void setNombreProductoBuscar(String nombreProductoBuscar) {
        this.nombreProductoBuscar = nombreProductoBuscar;
    }

    public List<String> getListanombreProductos() {
        return listanombreProductos;
    }

    public void setListanombreProductos(List<String> listanombreProductos) {
        this.listanombreProductos = listanombreProductos;
    } 
    
    

}
