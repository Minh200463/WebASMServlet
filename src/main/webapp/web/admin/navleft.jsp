<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<div class="collapse bg-secondary" style="width: 300px;" id="collapseExample">
  <div class="nav-header p-3 ms-5">
        <a href="/WebASMServlet/homepage">
          <img src="./img/Logo.png" class="img-fluid rounded-top" width="140px" alt="" />
        </a>
      </div>
      <div class="nav" style="height: 100vh; overflow-y: auto;">
        <ul class="nav flex-column">
          <h5 class="m-1 text-white fw-bold">Administration Tool</h5>
       
          <li class="nav-item">
            <button class="btn d-flex text-warning" type="button" data-bs-toggle="collapse" data-bs-target="#collapseUser"
              aria-expanded="false" aria-controls="collapseUser">
               <i class="bi bi-person-square me-2"></i> ${sessionScope.user.username}
            </button>
            <div class="collapse ms-4" id="collapseUser" data-bs-parent="#accordion">
              <ul class="nav flex-column">
                
                <li class="nav-item">
                  <a class="nav-link text-white" href="/WebASMServlet/homepage">Home</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link text-white" href="/WebASMServlet/page-favorite">Favorite</a>
                </li>
              </ul>
            </div>
          </li>
          <li class="nav-item">
            <button class="btn d-flex text-warning" type="button" data-bs-toggle="collapse" data-bs-target="#collapseDashboards"
              aria-expanded="false" aria-controls="collapseDashboards">
              <i class="bi bi-sliders2-vertical me-2"></i> Maganement
            </button>
            <div class="collapse show ms-4" id="collapseDashboards" data-bs-parent="#accordion">
              <ul class="nav flex-column">
                <li class="nav-item">
                  <a class="nav-link text-white" href="/WebASMServlet/admin-home">List video</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link text-white" href="/WebASMServlet/admin-videos">Edit video</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link text-white" href="/WebASMServlet/admin-users">User</a>
                </li>
              </ul>
            </div>
          </li>
          <li class="nav-item">
            <button class="btn d-flex text-warning" type="button" data-bs-toggle="collapse" data-bs-target="#collapseDocument"
              aria-expanded="false" aria-controls="collapseDocument">
              <i class="bi bi-book me-2"></i> Report
            </button>
            <div class="collapse ms-4" id="collapseDocument" data-bs-parent="#accordion">
              <ul class="nav flex-column">
                <li class="nav-item">
                  <a class="nav-link text-white" href="/WebASMServlet/report">Video yêu thích theo năm</a>
                </li>
              </ul>
            </div>
          </li>
        </ul>
      </div>
    </div>