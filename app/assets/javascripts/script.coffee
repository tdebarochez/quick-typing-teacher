$ ->
  input = $ 'section :input'
  input
    .on 'keyup', (evt) ->
      return renewLetter() if evt.key is "Enter"
      letter = input.val().substr(-1)
      $.ajax("/check",
        dataType: "json"
        data:
          letter: letter
      ).done (result) ->
        renewLetter() if result
    .fancyInput()[0].focus()

  renewLetter = () ->
    $.ajax("/letter",
      dataType: "json"
    ).done (result) ->
      $('#top span').text(result)
      input.val('')
      $('.fancyInput > div > span').remove()