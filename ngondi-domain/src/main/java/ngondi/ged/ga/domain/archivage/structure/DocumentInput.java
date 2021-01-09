package ngondi.ged.ga.domain.archivage.structure;

/**
 * 
 * @author gmihindou
 *
 */
public class DocumentInput {
	private String archiveFormat;
	private String nameDocument;
	private byte[] docBytes;

	/**
	 * 
	 */
	public DocumentInput() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 * @param archiveFormat
	 * @param nameDocument
	 * @param docBytes
	 */
	public DocumentInput(String archiveFormat, String nameDocument, byte[] docBytes) {
		super();
		this.archiveFormat = archiveFormat;
		this.nameDocument = nameDocument;
		this.docBytes = docBytes;
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

}
