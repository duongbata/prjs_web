function validateLogon() {
	var id = $('#login-username').val();
	if ((id == null) || (id == '')) {
		alert('Hãy điền user id');
		return false;
	}
	var isNotNumber = isNaN(id);
	if (isNotNumber) {
		alert('id phải là số');
		return false;
	}
	return true;
}