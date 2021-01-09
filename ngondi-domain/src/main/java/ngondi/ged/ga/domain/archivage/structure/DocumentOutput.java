/**
 * 
 */
package ngondi.ged.ga.domain.archivage.structure;

import java.time.LocalDate;

/**
 * @author gmihindou
 *
 */
public class DocumentOutput {
	private String idDocument;
	private String archiveFormat;
	private String nameDocument;
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

	private byte[] docBytes;

	/**
	 * 
	 * @param idDocument
	 * @param archiveFormat
	 * @param nameDocument
	 * @param docBytes
	 */
	public DocumentOutput(String idDocument, String archiveFormat, String nameDocument, byte[] docBytes) {
		super();
		this.idDocument = idDocument;
		this.archiveFormat = archiveFormat;
		this.nameDocument = nameDocument;
		this.docBytes = docBytes;
	}

	/**
	 * 
	 */
	public DocumentOutput() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the idDocument
	 */
	public String getIdDocument() {
		return idDocument;
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
	 * @param idDocument the idDocument to set
	 */
	public void setIdDocument(String idDocument) {
		this.idDocument = idDocument;
	}

}
