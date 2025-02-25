package com.hao_xiao_zi.bank.web;

import com.hao_xiao_zi.bank.execption.MoneyNotEnoughException;
import com.hao_xiao_zi.bank.execption.TransferException;
import com.hao_xiao_zi.bank.service.AccountService;
import com.hao_xiao_zi.bank.service.impl.AccountServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-02-25
 * Time: 16:52
 */
@WebServlet("/transfer")
public class TransferAccountServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //获取数据
        String fromTransfer = request.getParameter("sender");
        String toTransfer = request.getParameter("receiver");
        Double money = Double.parseDouble(request.getParameter("amount"));

        //进行调度，交由业务层进行业务处理
        AccountService accountService = new AccountServiceImpl();

        try {
            accountService.AccountTransfer(fromTransfer,toTransfer,money);
            //转账成功,进行页面展示
            response.sendRedirect("/bank/succeed.html");
        } catch (MoneyNotEnoughException e) {
            response.sendRedirect("/bank/moneyNotEnough.html");
        } catch (TransferException e) {
            response.sendRedirect("/bank/error.html");
        }
    }
}
