package com.ERetail.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class ProdukDto {

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class CreateProdukDto {

		private Long idSupplier;
		private Long idBrand;
		private Long idKategori;
		private String namaProduk;
		private String deskripsiProduk;
		private Integer harga;
		private Integer stok;
	}

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class UpdateProdukDto {

		private Long idProduk;
		private Long idSupplier;
		private Long idBrand;
		private Long idKategori;
		private String namaProduk;
		private String deskripsiProduk;
		private Integer harga;
		private Integer stok;
	}
}
