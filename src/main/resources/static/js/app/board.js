var main = {
    init : function() {
        var _this = this;
        $('#btn-post-save').on('click', function() {
            _this.save();
        });

        $('#btn-post-update').on('click', function() {
            _this.update();
        });

        $('#btn-post-delete').on('click', function() {
            _this.delete();
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
    },
    update : function() {
        var data = {
            title: $('#title').val(),
            content: $('#content').val()
        };

        var idx = $('#idx').text();

        $.ajax({
            type: 'PUT',
            url: '/api/post/' + idx,
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('수정하였습니다.');
            window.location.href = '/board';
        }).fail(function(error) {
            alert(JSON.stringify(error));
        });
    },
    delete : function() {
        var idx = $('#idx').text();

        $.ajax({
            type: 'DELETE',
            url: '/api/post/' + idx,
            dataType: 'json',
            contentType: 'application/json; charset=utf-8'
        }).done(function() {
            alert('글을 삭제했습니다.');
            window.location.href = '/post/' + idx;
        }).fail(function(error) {
            alert('제목을 입력해주세요');
        });
    }
};

main.init();
