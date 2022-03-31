package Model;

import java.time.LocalDate;

public class Cetificate {
	private int certificateId;
	private String certificateName;
	private String certificateRank;
	private LocalDate certificateDate;
	public Cetificate(int certificateId, String certificateName, String certificateRank, LocalDate certificateDate) {
		super();
		this.certificateId = certificateId;
		this.certificateName = certificateName;
		this.certificateRank = certificateRank;
		this.certificateDate = certificateDate;
	}
	public int getCertificateId() {
		return certificateId;
	}
	public void setCertificateId(int certificateId) {
		this.certificateId = certificateId;
	}
	public String getCertificateName() {
		return certificateName;
	}
	public void setCertificateName(String certificateName) {
		this.certificateName = certificateName;
	}
	public String getCertificateRank() {
		return certificateRank;
	}
	public void setCertificateRank(String certificateRank) {
		this.certificateRank = certificateRank;
	}
	public LocalDate getCertificateDate() {
		return certificateDate;
	}
	public void setCertificateDate(LocalDate certificateDate) {
		this.certificateDate = certificateDate;
	}
	@Override
	public String toString() {
		return "Cetificate [certificateId=" + certificateId + ", certificateName=" + certificateName
				+ ", certificateRank=" + certificateRank + ", certificateDate=" + certificateDate + "]";
	}
	
}
