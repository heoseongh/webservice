var main = {
    init : function () {
        var _this = this;
        // 등록 버튼을 누르면 save 함수 실행
        $('#btn-save').on('click', function () {
            _this.save();
        });
        // 수정 버튼을 누르면 update 함수 실행
        $('#btn-update').on('click', function () {
            _this.update();
        });

        $('#btn-delete').on('click', function () {
            _this.delete();
        });
    },
    // 게시글 저장 기능
    save : function () {
        var data = {
            title: $('#title').val(),
            author: $('#author').val(),
            content: $('#content').val()
        };

        $.ajax({
            type: 'POST',
            url: '/api/v1/posts',
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('글이 등록되었습니다.');
            window.location.href = '/';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },
    // 게시글 수정 기능
    update : function () {
        var data = {
            title: $('#title').val(),
            content: $('#content').val()
        };

        var id = $('#id').val();

        $.ajax({
            type: 'PUT',    // PostApiController에서 @PutMapping으로 선언했기 때문에 PUT을 사용. -> REST 규약에 맞게 설정된 것이다.
            url: '/api/v1/posts/'+id,   // 어느 게시글을 수정할지 URL Path로 구분하기 위해 Path에 id를 추가한다.
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('글이 수정되었습니다.');
            window.location.href = '/';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },
    // 게시글 삭제 기능
    delete : function () {

        // 삭제 기능이니 data 객체는 필요 없음.

        var id = $('#id').val();

        $.ajax({
            type: 'DELETE',
            url: '/api/v1/posts/'+id,
            dataType: 'json',
            contentType:'application/json; charset=utf-8'
        }).done(function() {
            alert('글이 삭제되었습니다.');
            window.location.href = '/';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    }

};

main.init();