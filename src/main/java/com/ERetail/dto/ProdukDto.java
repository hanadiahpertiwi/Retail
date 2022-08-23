package com.ERetail.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class ProdukDto {

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class CreateProdukDto {

		private Long id_supplier;
		private Long id_brand;
		private Long id_kategori;
		private String nama_produk;
		private String deskripsi_produk;
		private Integer harga;
		private Integer stok;
	}

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class UpdateProdukDto {

		private Long id_produk;
		private Long id_supplier;
		private Long id_brand;
		private Long id_kategori;
		private String nama_produk;
		private String deskripsi_produk;
		private Integer harga;
		private Integer stok;
	}
}
