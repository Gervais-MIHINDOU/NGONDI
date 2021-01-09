/**
 * 
 */
package ngondi.ged.ga.infrastructure.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;

/**
 * @author gmihindou
 *
 */
@Entity(name = "DOCUMENT")
public class DocumentEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "idDocument")
	private String idDocument;

	@Column(name = "archive_format")
	private String archiveFormat;
	@Column(name = "document_name")
	private String nameDocument;

	@Column(length = 720971520)
	@Lob
	private byte[] docBytes;

	@Column(name = "date_save")
	private LocalDate date;

	/**
	 * @return the date
	 */
	public LocalDate getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(LocalDate date) {
		this.date = date;
	}

	/**
	 * 
	 * @return
	 */
	public byte[] getDocBytes() {
		return docBytes;
	}

	/**
	 * 
	 * @param docBytes
	 */
	public void setDocBytes(byte[] docBytes) {
		this.docBytes = docBytes;
	}

	/**
	 * @return the idDocument
	 */
	public String getIdDocument() {
		return idDocument;
	}

	/**
	 * @param idDocument the idDocument to set
	 */
	public void setIdDocument(String idDocument) {
		this.idDocument = idDocument;
	}

	/**
	 * @return the archiveFormat
	 */
	public String getArchiveFormat() {
		return archiveFormat;
	}

	/**
	 * @param archiveFormat the archiveFormat to set
	 */
	public void setArchiveFormat(String archiveFormat) {
		this.archiveFormat = archiveFormat;
	}

	/**
	 * @return the nameDocument
	 */
	public String getNameDocument() {
		return nameDocument;
	}

	/**
	 * @param nameDocument the nameDocument to set
	 */
	public void setNameDocument(String nameDocument) {
		this.nameDocument = nameDocument;
	}

}
