# ssr-parse

```txt
ss://YWVzLTI1Ni1jZmI6UW96enV6THMyVzMyQDIxMS43NS43OS4yMzM6MTY1MDU=
ssr://MTcyLjEwNC44Ni42MDo4MDk5Om9yaWdpbjphZXMtMjU2LWNmYjpwbGFpbjpaVWxYTUVSdWF6WTVORFUwWlRadVUzZDFjM0IyT1VSdFV6SXdNWFJSTUVRLz9yZW1hcmtzPTVwZWw1cHlzTFZSdmEzbHYmZ3JvdXA9VjFkWExsbFBWVTVGUlVRdVYwbE8=
```

其实，`ss://…`及`ssr://…`这样的链接都是经过`url_safe`、`Base64`编码生成的。换句话讲，就是先通过标准的 `Base64`编码，然后再把编码内容中的`+`和`/`分别替换为`-`和`_`这两个字符。这点很重要，解码的时候要进行反向替换，不然就会出错。

## ss链接

在 Base64 编码之前，ss链接的格式是这样的：

```txt
ss://method:password@server:port
```

也就是说，一般我们见到的链接就是`ss://Base64`编码字段 ，其中`method:password@server:port`这部分被进行了`Base64`编码。

## ssr链接

在 Base64 编码之前，ssr 链接的格式是这样的：

```txt
ssr://server:port:protocol:method:obfs:password_base64/?params_base64
```

上面的链接的不同之处在于`password_base64`和`params_base64`。顾名思义，`password_base64`就是密码被 base64编码后的字符串，而`params_base64`则是协议参数、混淆参数、备注及Group对应的参数值被base64编码后拼接而成的字符串。

即 params_base64为这些字段的拼接：

```txt
obfsparam=obfsparam_base64&protoparam=protoparam_base64&remarks=remarks_base64&group=group_base64
```

更详细的格式

```txt
server:server_port:protocol:method:obfs:password/?obfsparam=obfs_param&protoparam=protocol_param&remarks=remarks&group=group
```
