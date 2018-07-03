/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function deleteClicked(el)
{
    var id = el.getAttribute('data-id');
    var form = document.createElement('form');
    form.setAttribute('method', 'post');
    form.setAttribute('action', '/delete');
    var input = document.createElement("input");
    input.setAttribute("type", "hidden");
    input.setAttribute("name", "id");
    input.setAttribute("value", id);
    form.appendChild(input);
    form.style.display = 'hidden';
    document.body.appendChild(form);
    form.submit();
}

function editClicked(el)
{
    var trNode = el.parentNode.parentNode;
    console.log(trNode.outerHTML);
    var td0 = trNode.children[0];
    var td1 = trNode.children[1];
    var td2 = trNode.children[2];

    if (el.value == "edit")
    {
        el.value = "update";
        td0.setAttribute('contenteditable', true);
        td1.setAttribute('contenteditable', true);
        td2.setAttribute('contenteditable', true);
    }
    else
    {
        el.value = "edit";
        td0.setAttribute('contenteditable', false);
        td1.setAttribute('contenteditable', false);
        td2.setAttribute('contenteditable', false);
        var oldId = el.getAttribute('data-id');
        var newId = td0.innerText;
        var name = td1.innerText;
        var age = td2.innerText;
        var form = document.createElement('form');
        form.setAttribute('method', 'post');
        form.setAttribute('action', '/update');

        // Adding Post Request Parameters via hidden input fields

        var input0 = document.createElement("input");
        input0.setAttribute("type", "hidden");
        input0.setAttribute("name", "oldId");
        input0.setAttribute("value", oldId);
        form.appendChild(input0);

        var input1 = document.createElement("input");
        input1.setAttribute("type", "hidden");
        input1.setAttribute("name", "newId");
        input1.setAttribute("value", newId);
        form.appendChild(input1);

        var input2 = document.createElement("input");
        input2.setAttribute("type", "hidden");
        input2.setAttribute("name", "name");
        input2.setAttribute("value", name);
        form.appendChild(input2);

        var input3 = document.createElement("input");
        input3.setAttribute("type", "hidden");
        input3.setAttribute("name", "age");
        input3.setAttribute("value", age);
        form.appendChild(input3);

        form.style.display = 'hidden';
        document.body.appendChild(form);
        form.submit();
    }
}