/**
 * 
 */
package ngondi.ged.ga.exposition.structure;

import java.time.LocalDate;

/**
 * @author gmihindou
 *
 */
public class ResponseDocumentDTO {
	private String idDocument;
	private String archiveFormat;
	private String nameDocument;
	private byte[] docBytes;
	private LocalDate date;
	private ErrorGed errors;

	/**
	 * 
	 */
	public ResponseDocumentDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param errors
	 */
	public ResponseDocumentDTO(ErrorGed errors) {
		super();
		this.errors = errors;
	}

	/**
	 * @param idDocument
	 * @param archiveFormat
	 * @param nameDocument
	 * @param docBytes
	 * @param date
	 */
	public ResponseDocumentDTO(String idDocument, String archiveFormat, String nameDocument, byte[] docBytes,
			LocalDate date) {
		super();
		this.idDocument = idDocument;
		this.archiveFormat = archiveFormat;
		this.nameDocument = nameDocument;
		this.docBytes = docBytes;
		this.date = date;
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

	/**
	 * @return the docBytes
	 */
	public byte[] getDocBytes() {
		return docBytes;
	}

	/**
	 * @param docBytes the docBytes to set
	 */
	public void setDocBytes(byte[] docBytes) {
		this.docBytes = docBytes;
	}

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
	 * @return the errors
	 */
	public ErrorGed getErrors() {
		return errors;
	}

	/**
	 * @param errors the errors to set
	 */
	public void setErrors(ErrorGed errors) {
		this.errors = errors;
	}

}
