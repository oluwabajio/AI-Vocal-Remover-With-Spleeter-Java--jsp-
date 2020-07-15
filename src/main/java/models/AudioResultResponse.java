package models;

public class AudioResultResponse {
    private Boolean error;
    private String message;
    private String file_path;
    private String vocal_path;
    private String instrumental_path;


    public Boolean getError() {
        return error;
    }

    public void setError(Boolean error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getFile_path() {
        return file_path;
    }

    public void setFile_path(String file_path) {
        this.file_path = file_path;
    }

    public String getVocal_path() {
        return vocal_path;
    }

    public void setVocal_path(String vocal_path) {
        this.vocal_path = vocal_path;
    }

    public String getInstrumental_path() {
        return instrumental_path;
    }

    public void setInstrumental_path(String instrumental_path) {
        this.instrumental_path = instrumental_path;
    }
}
