'use strict';

describe('Controller: EpicCtrl', function () {

  // load the controller's module
  beforeEach(module('taaTaskManagerApp'));

  var EpicCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    EpicCtrl = $controller('EpicCtrl', {
      $scope: scope
      // place here mocked dependencies
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(EpicCtrl.awesomeThings.length).toBe(3);
  });
});
