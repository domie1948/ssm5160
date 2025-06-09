const base = {
    get() {
                return {
            url : "http://localhost:8080/ssmiagf8/",
            name: "ssmiagf8",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/ssmiagf8/front/index.html'
        };
            },
    getProjectName(){
        return {
            projectName: "动漫评论网站"
        } 
    }
}
export default base
