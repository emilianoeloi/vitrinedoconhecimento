function writeMessage(type, message){
    var $alertElement = $(".alert"),
        strongText = '',
        spamText = '',
        successClass = 'alert-success',
        errorClass = 'error-success',
        klass = '';
    $alertElement.removeClass(successClass);
    $alertElement.removeClass(errorClass);
    switch(type){
        case 'success':
            strongText = 'Sucesso',
            spamText = message;
            klass = successClass;
            break;
        case 'error':
            strongText = 'Erro',
            spamText = message;
            klass = errorClass;
            break;
        default:
            strongText = '',
            spamText = message;
            klass = '';
            break;
    }
    $alertElement.addClass(klass);
    $alertElement.find('strong').text(strongText);
    $alertElement.find('spam').text(spamText);
}