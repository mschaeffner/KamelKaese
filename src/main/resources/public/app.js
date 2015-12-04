$("#submit").click(function() {

    var input = $("#input").val();

    console.log(input);

    $.ajax({
        type: "POST",
        url: "/KamelKäse",
        processData: false,
        contentType: 'text/plain',
        data: input,
        success: function(result) {
            $("#output").html(result);
        }

    });

    return false;
});
