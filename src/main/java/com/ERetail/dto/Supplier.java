package com.ERetail.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class Supplier {

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class CreateSupplierDto {

		private String nama_supplier;
		private String email;
		private String no_telp;
		private String alamat_supplier;
		private long id_region;
	}

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class UpdateSupplierDto {

		private Long id_supplier;
		private String nama_supplier;
		private String email;
		private String no_telp;
		private String alamat_supplier;
		private long id_region;
	}
}
