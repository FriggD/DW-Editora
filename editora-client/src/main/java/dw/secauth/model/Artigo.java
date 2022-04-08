package dw.secauth.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Artigo {
    public long id;
    public String titulo;
    public String resumo;
    public boolean publicado;

	public void setId(String id) {
		this.id = Long.parseLong(id);
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public void setResumo(String resumo) {
		this.resumo = resumo;
	}

	// public Artigo(String titulo, String resumo) {
	// 	this.titulo = titulo;
	// 	this.resumo = resumo;
	// 	this.publicado = false;
	// }
}

