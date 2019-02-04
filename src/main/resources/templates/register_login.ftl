        <!-- 注册窗口 -->
        <div id="register" class="modal fade" tabindex="-1">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-body">
                        <button class="close" data-dismiss="modal">
                            <span>&times;</span>
                        </button>
                    </div>
                    <div class="modal-title">
                        <h1 class="text-center">注册</h1>
                    </div>
                    <div class="modal-body">
                        <form class="form-group" action="">
                            <div class="form-group">
                                <label for="">用户名</label>
                                <input id="ruserName" class="form-control" oninvalid="checkUserName(this)" oninput="checkUserName(this)" pattern="^[a-zA-Z0-9]{6,15}$"  type="text" required  placeholder="6-15位字母或数字">
                            </div>
                            <div class="form-group">
                                <label for="">密码</label>
                                <input id="rpassword1" class="form-control" oninvalid="checkPassword(this)" oninput="checkPassword(this)" pattern="^[a-zA-Z0-9]{6,}$" type="password" required  placeholder="至少6位字母或数字">
                            </div>
                            <div class="form-group">
                                <label for="">再次输入密码</label>
                                <input id="rpassword2" class="form-control" oninvalid="checkSecondPassword(this,'rpassword1')" oninput="checkSecondPassword(this,'rpassword1')" pattern="^[a-zA-Z0-9]{6,}$" type="password" required  placeholder="至少6位字母或数字">
                            </div>
                            <div class="form-group">
                                <label for="">邮箱</label>
                                <input id="remail" class="form-control" oninvalid="checkEmail(this)" oninput="checkEmail(this)"  type="email" required placeholder="例如:123@123.com">
                            </div>
                            <div class="text-right">
                                <button id="btn_register" class="btn btn-primary" type="submit">提交</button>
                                <button id="btn_cancleR" class="btn btn-danger" data-dismiss="modal">取消</button>
                            </div>
                            <a href="" data-toggle="modal" data-dismiss="modal" data-target="#login">已有账号？点我登录</a>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <!-- 登录窗口 -->
        <div id="login" class="modal fade">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-body">
                        <button class="close" data-dismiss="modal">
                            <span>&times;</span>
                        </button>
                    </div>
                    <div class="modal-title">
                        <h1 class="text-center">登录</h1>
                    </div>
                    <div class="modal-body">
                        <form class="form-group" action="">
                            <div class="form-group">
                                <label for="">用户名</label>
                                <input id="userName" class="form-control" required oninvalid="checkUserName(this)" oninput="checkUserName(this)" pattern="^[a-zA-Z0-9]{6,15}$" type="text" placeholder="">
                            </div>
                            <div class="form-group">
                                <label for="">密码</label>
                                <input id="password" class="form-control" required oninvalid="checkPassword(this)" oninput="checkPassword(this)" pattern="^[a-zA-Z0-9]{6,}$"  type="password" placeholder="">
                            </div>
                            <div class="text-right">
                                <button id="btn_login"  class="btn btn-primary" type="submit">登录</button>
                                <button id="btn_cancelL" class="btn btn-danger" data-dismiss="modal">取消</button>
                            </div>
                            <a href="" data-toggle="modal" data-dismiss="modal" data-target="#register">还没有账号？点我注册</a>
                        </form>
                    </div>
                </div>
            </div>
        </div>