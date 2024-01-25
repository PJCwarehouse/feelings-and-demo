当在HTML中使用Thymeleaf模板引擎结合JavaScript时，可以通过`th:attr`语法设置HTML标签的属性，以将后端数据传递给前端。
例如，使用
`th:attr="data-articleid=${article.id}"`
语法将`article.id`的值设置为`data-articleid`属性。
(有没有th:attr都可以)
在JavaScript中，可以通过`$(element).data("articleid")`来获取HTML元素上设置的`data-articleid`属性的值。这样，你可以在按钮点击事件中获取对应的`articleId`值，然后将其传递给后续的JavaScript函数，比如在确认删除时调用`deleteArticle`函数。
在JavaScript中，element 代表了HTML元素，通常通过DOM（文档对象模型）来获取。
例如:
$(button).data("articleid")就是botton元素
总体而言，这种方法充分利用了Thymeleaf和JavaScript的结合使用，使得从后端传递数据到前端并进行交互变得更加灵活和方便。