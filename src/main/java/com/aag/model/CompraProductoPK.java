package com.aag.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class CompraProductoPK implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -554861074405554639L;

	@ManyToOne
	@JoinColumn(name = "id_producto", nullable = false)
	private Producto producto;
	
	@ManyToOne
	@JoinColumn(name = "id_venta", nullable = false)
	private Venta venta;
	
	@Override
	public int hashCode() {
		final int prime = 7;
		int result = 1;
		result = prime * result + ((producto == null) ? 0 : producto.hashCode());
		result = prime * result + ((venta == null) ? 0 : venta.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if(getClass() != obj.getClass())
			return false;
		
		CompraProductoPK other = (CompraProductoPK) obj;
		if (venta == null) {
			if (other.venta != null)
				return false;
		}else if (!venta.equals(other.venta)) {
			return false;
		}else if (!producto.equals(other.producto)) {
			return false;
		}
		
		return true;
	}
	
	
}
