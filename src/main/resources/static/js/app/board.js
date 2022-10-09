var main = {
    init : function() {
        var _this = this;
        $('#btn-save').on('click', function() {
            _this.save();
        });
    },
    save : function() {
        var data = {
            title : $('#title').val(),
            author : $('#author').val(),
            content : $('#content').val()
        };

        $.ajax({
            type: 'POST',
            url: '/api/post',
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('글을 등록하였습니다.');
            window.location.href = '/board';
        }).fail(function(error) {
            alert(JSON.stringify(error));
        });
    }
};

main.init();
