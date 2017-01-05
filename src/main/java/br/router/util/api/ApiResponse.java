package br.router.util.api;


import br.router.util.alert.AlertMessage;
import br.router.util.alert.AlertSet;

public class ApiResponse {
	private ResponseStatus status;
	private Object object;
	private AlertMessage alert;
	
	public ApiResponse() {
		this(ResponseStatus.DONE, null, null);
	}
	
	public ApiResponse(ResponseStatus status, Object object, AlertMessage alert) {
		this.status = status;
		this.object = object;
		this.alert = alert;
	}
	
	public ApiResponse withDoneStatus() {
		this.status = ResponseStatus.DONE;
		return this;
	}
	
	public ApiResponse withFailStatus() {
		this.status = ResponseStatus.FAIL;
		return this;
	}
	
	public ApiResponse withShortInfoMessage(String message) {
		this.alert = new AlertSet().withShortInfo(message).get(0);
		return this;
	}
	
	public ApiResponse withShortSuccessMessage(String message) {
		this.alert = new AlertSet().withShortSuccess(message).get(0);
		return this;
	}
	
	public ApiResponse withShortWarningMessage(String message) {
		this.alert = new AlertSet().withShortWarning(message).get(0);
		return this;
	}
	
	public ApiResponse withShortErrorMessage(String message) {
		this.alert = new AlertSet().withShortError(message).get(0);
		return this;
	}
	
	public ApiResponse withLongInfoMessage(String message) {
		this.alert = new AlertSet().withLongInfo(message).get(0);
		return this;
	}
	
	public ApiResponse withLongSuccessMessage(String message) {
		this.alert = new AlertSet().withLongSuccess(message).get(0);
		return this;
	}
	
	public ApiResponse withLongWarningMessage(String message) {
		this.alert = new AlertSet().withLongWarning(message).get(0);
		return this;
	}
	
	public ApiResponse withLongErrorMessage(String message) {
		this.alert = new AlertSet().withLongError(message).get(0);
		return this;
	}
	
	public ApiResponse withObject(Object object) {
		this.object = object;
		return this;
	}

	public ResponseStatus getStatus() {
		return status;
	}

	public void setStatus(ResponseStatus status) {
		this.status = status;
	}

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}

	public AlertMessage getAlert() {
		return alert;
	}

	public void setAlert(AlertMessage alert) {
		this.alert = alert;
	}
	
}
