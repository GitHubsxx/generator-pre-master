${baseData}

<style type="text/css">
    #input{width:100%;border:1px solid #cccccc;line-height:20px;cellpadding:0px;cellspacing:0px; border-collapse: collapse}
    #input td{border:1px solid #cccccc;font-size:12px;line-height:20px;white-space: nowrap}
</style>
<script>
    $(function(){
        $("#input tr").each(function(){
            $(this).children("td:first").css("width","20%");
            $(this).children("td:first").css("text-align","right");
        });
    });
</script>
